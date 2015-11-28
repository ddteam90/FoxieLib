package foxie.lib;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import foxie.lib.proxy.ProxyCommon;

@Mod(modid = FoxieLib.MODID, name = FoxieLib.NAME, version = FoxieLib.VERSION)
public class FoxieLib implements IFoxieMod {
   public static final String MODID   = "FoxieLib";
   public static final String NAME    = "Foxie Lib";
   public static final String VERSION = "@VERSION@";

   @SidedProxy(clientSide = "foxie.lib.proxy.ProxyClient", serverSide = "foxie.lib.proxy.ProxyCommon", modId = MODID)
   public static ProxyCommon proxy;

   @Mod.Instance(MODID)
   public static FoxieLib INSTANCE;

   private static Config config;

   @Mod.EventHandler
   public void preinit(FMLPreInitializationEvent event) {
      proxy.preinit(event);
      config = new Config(event.getSuggestedConfigurationFile());
   }

   @Mod.EventHandler
   public void init(FMLInitializationEvent event) {
      proxy.init(event);
   }

   @Mod.EventHandler
   public void postinit(FMLPostInitializationEvent event) {
      proxy.postinit(event);
   }

   @Override
   public Config getConfig() {
      return config;
   }

   @Override
   public String getModId() {
      return MODID;
   }
}
