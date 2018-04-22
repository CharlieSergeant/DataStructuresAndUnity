using UnityEngine;
using System.Collections;

[RequireComponent(typeof(Controller2D))]
public class Player : MonoBehaviour
{

    public float maxJumpHeight = 4;
    public float minJumpHeight = 1;
    public float timeToJumpApex = .4f;
    float accelerationTimeAirborne = .2f;
    float accelerationTimeGrounded = .1f;
    float moveSpeed = 12;

    public Vector2 wallJumpClimb;
    public Vector2 wallJumpOff;
    public Vector2 wallLeap;

    public float wallSlideSpeedMax = 3;
    public float wallStickTime = .25f;
    float timeToWallUnstick;

    float gravity;
    float maxJumpVelocity;
    float minJumpVelocity;
    Vector3 velocity;
    float velocityXSmoothing;
    public bool directionFace = true;

   
    public float fireRate;

    private float nextFire;

    Controller2D controller;
    
    //sprite movement
    public Sprite sprite1;
    public Sprite sprite2;
    public Sprite sprite1F;
    public Sprite sprite2F;
    public Sprite spriteNorm;
    private SpriteRenderer spriteRenderer;

   

    void Start()
    {
        controller = GetComponent<Controller2D>();

        gravity = -(2 * maxJumpHeight) / Mathf.Pow(timeToJumpApex, 2);
        maxJumpVelocity = Mathf.Abs(gravity) * timeToJumpApex;
        minJumpVelocity = Mathf.Sqrt(2 * Mathf.Abs(gravity) * minJumpHeight);
        print("Gravity: " + gravity + "  Jump Velocity: " + maxJumpVelocity);
        //
        spriteRenderer = GetComponent<SpriteRenderer>(); // we are accessing the SpriteRenderer that is attached to the Gameobject
        if (spriteRenderer.sprite == null) // if the sprite on spriteRenderer is null then
            spriteRenderer.sprite = sprite1; // set the sprite to sprite1

        

    }

    void Update()
    {
        //sprites
        if (Input.GetKey(KeyCode.RightArrow)) // If the space bar is pushed down
        {
            
            ChangeTheDamnSprite(); // call method to change sprite
        }
        
        if (Input.GetKey(KeyCode.LeftArrow)) // If the space bar is pushed down
        {
            ChangeTheDamnSpriteF(); // call method to change sprite
        }
       
       


        // 5 - Shooting
        bool shoot = Input.GetButtonDown("Fire1");
        // Careful: For Mac users, ctrl + arrow is a bad idea

        if (shoot)
        {
            WeaponScript weapon = GetComponent<WeaponScript>();
            if (weapon != null)
            {
                // false because the player is not an enemy
                weapon.Attack(false);
            }
        }

        



        Vector2 input = new Vector2(Input.GetAxisRaw("Horizontal"), Input.GetAxisRaw("Vertical"));
        int wallDirX = (controller.collisions.left) ? -1 : 1;

        float targetVelocityX = input.x * moveSpeed;
        velocity.x = Mathf.SmoothDamp(velocity.x, targetVelocityX, ref velocityXSmoothing, (controller.collisions.below) ? accelerationTimeGrounded : accelerationTimeAirborne);
        
        bool wallSliding = false;
        if ((controller.collisions.left || controller.collisions.right) && !controller.collisions.below && velocity.y < 0)
        {
            wallSliding = true;

            if (velocity.y < -wallSlideSpeedMax)
            {
                velocity.y = -wallSlideSpeedMax;
            }

            if (timeToWallUnstick > 0)
            {
                velocityXSmoothing = 0;
                velocity.x = 0;

                if (input.x != wallDirX && input.x != 0)
                {
                    timeToWallUnstick -= Time.deltaTime;
                }
                else
                {
                    timeToWallUnstick = wallStickTime;
                }
            }
            else
            {
                timeToWallUnstick = wallStickTime;
            }

        }

        if (Input.GetKeyDown(KeyCode.UpArrow))
        {
            if (wallSliding)
            {
                if (wallDirX == input.x)
                {
                    velocity.x = -wallDirX * wallJumpClimb.x;
                    velocity.y = wallJumpClimb.y;
                }
                else if (input.x == 0)
                {
                    velocity.x = -wallDirX * wallJumpOff.x;
                    velocity.y = wallJumpOff.y;
                }
                else
                {
                    velocity.x = -wallDirX * wallLeap.x;
                    velocity.y = wallLeap.y;
                }
            }
            if (controller.collisions.below)
            {
                velocity.y = maxJumpVelocity;
            }
        }
        if (Input.GetKeyUp(KeyCode.UpArrow))
        {
            if (velocity.y > minJumpVelocity)
            {
                velocity.y = minJumpVelocity;
            }
        }


        velocity.y += gravity * Time.deltaTime;
        controller.Move(velocity * Time.deltaTime, input);

        if (controller.collisions.above || controller.collisions.below)
        {
            velocity.y = 0;
        }

    }
    void ChangeTheDamnSprite()
    {
        directionFace = true;

        if (spriteRenderer.sprite == sprite1) // if the spriteRenderer sprite = sprite1 then change to sprite2
        {
            spriteRenderer.sprite = sprite2;
        }
        else
        {
            spriteRenderer.sprite = sprite1; // otherwise change it back to sprite1
        }
    }
    void ChangeTheDamnSpriteF()
    {
        directionFace = false;

        if (spriteRenderer.sprite == sprite1F) // if the spriteRenderer sprite = sprite1 then change to sprite2
        {
            spriteRenderer.sprite = sprite2F;
        }
        else
        {
            spriteRenderer.sprite = sprite1F; // otherwise change it back to sprite1
        }
    }
    void ChangeTheDamnSpriteNorm()
    {
        spriteRenderer.sprite = spriteNorm;
    }

   

}
