using UnityEngine;
using System.Collections;

public class HowToPlayMenu : MonoBehaviour {

    public void PlayGame()
    {
        Application.LoadLevel(1);
    }

    public void Directions()
    {
        Application.LoadLevel(3);
    }

    public void MainMenu()
    {
        Application.LoadLevel(0);
    }
}
