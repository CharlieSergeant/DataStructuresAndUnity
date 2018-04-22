using UnityEngine;
using System.Collections;

public class hpPrint : MonoBehaviour
{

    public Rect rectOfMyButton2;

    private PlayerHealthScript player;
    void Start()
    {
        
        rectOfMyButton2 = new Rect(800, 0, 400, 400);
    }

    void OnGUI()
    {
        GUI.Label(rectOfMyButton2, ("Health:"+ player.GetComponent<PlayerHealthScript>().hp+ ""));
    }

}
