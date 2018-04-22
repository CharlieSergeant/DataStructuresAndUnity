using UnityEngine;
using System.Collections;

public class ScoreCount : MonoBehaviour {
    static public int gscore = 0;
    static public int setPlayerHealth = 0;

    public Rect rectOfMyButton;
    public Rect rectOfMyButton2;


    private PlayerHealthScript player;

    void Start()
    {
        rectOfMyButton = new Rect(0, 0, 400, 400);
        rectOfMyButton2 = new Rect(300, 0, 400, 400);

    }

	void OnGUI ()
    {
        GUI.Label(rectOfMyButton, ("Score " + gscore));
        GUI.Label(rectOfMyButton2, ("Health " + setPlayerHealth));

    }
    
    
}
