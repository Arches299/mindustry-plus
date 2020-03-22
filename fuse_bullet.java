package mindustry.content;

import arc.*;
import arc.struct.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.type.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.modules.*;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.ctype.ContentList;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.type.*;
import mindustry.graphics.*;
import mindustry.world.*;
import static mindustry.Vars.*;

public class Bullets implements ContentList{
    public static BulletType

                fuseBullet;
        
            @Override
    public void load(){

fuseBullet = new BulletType(0.01f, 2010, "shell"){
    {
                    hitEffect = Fx.hitLancer;
                    shootEffect = smokeEffect = Fx.lightningShoot;
                    lifetime = 10f;
                    despawnEffect = Fx.none;
                    pierce = true;
    }

                @Override
                public void init(mindustry.entities.type.Bullet b){
                    for(int i = 0; i < rays; i++){
                        Damage.collideLine(b, b.getTeam(), hitEffect, b.x, b.y, b.rot(), rayLength - Math.abs(i - (rays / 2)) * 20f);
                    }
                }

                @Override
                public void draw(Bullet b){
                    super.draw(b);
                    Draw.color(Color.white, Pal.lancerLaser, b.fin());
                    //Draw.alpha(b.fout());
                    for(int i = 0; i < 7; i++){
                        Tmp.v1.trns(b.rot(), i * 8f);
                        float sl = Mathf.clamp(b.fout() - 0.5f) * (80f - i * 10);
                        Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, 4f, sl, b.rot() + 90);
                        Drawf.tri(b.x + Tmp.v1.x, b.y + Tmp.v1.y, 4f, sl, b.rot() - 90);
                    }
                    Drawf.tri(b.x, b.y, 20f * b.fout(), (rayLength + 50), b.rot());
                    Drawf.tri(b.x, b.y, 20f * b.fout(), 10f, b.rot() + 180f);
                    Draw.reset();
                }
            });
        }};
    }
}
