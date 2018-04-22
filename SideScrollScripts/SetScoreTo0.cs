using UnityEngine;
using System.Collections;

public class SetScoreTo0 : MonoBehaviour {

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update ()
    {
        ScoreCount.gscore = 0;
        ScoreCount.setPlayerHealth = 20;
	}
}
