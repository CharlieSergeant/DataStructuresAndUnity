using UnityEngine;

/// <summary>
/// Simply moves the current game object
/// </summary>
public class EnemyMovement : MonoBehaviour
{
    // 1 - Designer variables

    /// <summary>
    /// Object speed
    /// </summary>
    public Vector2 speed = new Vector2(10, 10);

    /// <summary>
    /// Moving direction
    /// </summary>
    public Vector2 directionNeg = new Vector2(-1, 0);
    public Vector2 directionPos = new Vector2(1, 0);

    private Vector2 movement;
    int x = 0;
    int y = 0;

    void Update()
    {
        
        while (x < 20)
        {
            movement = new Vector2(speed.x * directionPos.x, speed.y * directionPos.y);
            x++;
        }

        while (y < 20)
        {
            movement = new Vector2(speed.x * directionNeg.x, speed.y * directionNeg.y);
            y++;
        }

    }

    void FixedUpdate()
    {
        // Apply movement to the rigidbody
        GetComponent<Rigidbody2D>().velocity = movement;
    }
}