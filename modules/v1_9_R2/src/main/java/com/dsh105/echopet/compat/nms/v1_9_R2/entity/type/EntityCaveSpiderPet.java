/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.dsh105.echopet.compat.nms.v1_9_R2.entity.type;

import com.dsh105.echopet.compat.api.entity.*;
import com.dsh105.echopet.compat.api.entity.type.nms.IEntityCaveSpiderPet;
import com.dsh105.echopet.compat.nms.v1_9_R2.entity.EntityPet;

import net.minecraft.server.v1_9_R2.World;
import net.minecraft.server.v1_9_R2.DataWatcherObject;

import org.bukkit.Sound;

@EntitySize(width = 0.7F, height = 0.5F)
@EntityPetType(petType = PetType.CAVESPIDER)
public class EntityCaveSpiderPet extends EntityPet implements IEntityCaveSpiderPet {


    EntityCaveSpiderPet(World world) {
        super(world);
    }

    public EntityCaveSpiderPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    protected void initDatawatcher() {
        super.initDatawatcher();
        getDatawatcher().register(EntitySpiderPet.SPIDER_IS_CLIMBING_METADATA, (byte) 0);
    }

    @Override
    protected void makeStepSound() {
        playSound(Sound.ENTITY_SPIDER_DEATH, 0.15F, 1.0F);
    }

    @Override
    protected Sound getIdleSound() {
        return Sound.ENTITY_SPIDER_AMBIENT;
    }

    @Override
    protected Sound getDeathSound() {
        return Sound.ENTITY_SPIDER_DEATH;
    }

    @Override
    public SizeCategory getSizeCategory() {
        return SizeCategory.REGULAR;
    }
}