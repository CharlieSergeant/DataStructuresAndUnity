using UnityEngine;

/// <summary>
/// Enemy generic behavior
/// </summary>
public class EnemyScript : MonoBehaviour
{
    private EnemyAttackScript weapon;

    void Awake()
    {
        // Retrieve the weapon only once
        weapon = GetComponent<EnemyAttackScript>();
    }

    void Update()
    {
        // Auto-fire
        if (weapon != null && weapon.CanAttack)
        {
            weapon.Attack(true);
        }
    }
}