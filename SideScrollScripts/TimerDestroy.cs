using UnityEngine;
using System.Collections;

public class TimerDestroy : MonoBehaviour
{
    public float interval;
	// Use this for initialization
	void Start ()
    {
	     
	}
	
	// Update is called once per frame
	void Update ()
    {
	    if(interval > 0)
        {
            interval -= Time.deltaTime;
        }
        else
        {
            enabled = false;
            Destroy(gameObject);
        }
	}
}
