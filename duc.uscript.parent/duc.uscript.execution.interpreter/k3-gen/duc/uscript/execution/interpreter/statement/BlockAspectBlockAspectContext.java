package duc.uscript.execution.interpreter.statement;

import duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties;
import duc.uscript.uScript.Block;
import java.util.Map;

@SuppressWarnings("all")
public class BlockAspectBlockAspectContext {
  public static final BlockAspectBlockAspectContext INSTANCE = new BlockAspectBlockAspectContext();
  
  public static BlockAspectBlockAspectProperties getSelf(final Block _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Block, BlockAspectBlockAspectProperties> map = new java.util.WeakHashMap<duc.uscript.uScript.Block, duc.uscript.execution.interpreter.statement.BlockAspectBlockAspectProperties>();
  
  public Map<Block, BlockAspectBlockAspectProperties> getMap() {
    return map;
  }
}
