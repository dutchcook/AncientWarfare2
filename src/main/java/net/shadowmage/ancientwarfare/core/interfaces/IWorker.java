package net.shadowmage.ancientwarfare.core.interfaces;

import net.minecraft.scoreboard.Team;
import net.shadowmage.ancientwarfare.core.interfaces.IWorkSite.WorkType;
import net.shadowmage.ancientwarfare.core.util.BlockPosition;

/**
 * IWorker interface marks entities and tile-entities that are capable of doing 'work'
 * @author Shadowmage
 */
public interface IWorker
{

/**
 * get worker effectiveness.  base == 1.  higher values are more effective at most work-types
 * @return
 */
public float getWorkEffectiveness();

/**
 * return the team that this worker belongs to, null for none
 * @return
 */
public Team getWorkerTeam();


public boolean canWorkAt(WorkType type);

}
