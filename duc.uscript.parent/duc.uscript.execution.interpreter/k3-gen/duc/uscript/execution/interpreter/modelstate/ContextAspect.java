package duc.uscript.execution.interpreter.modelstate;

import duc.uscript.execution.Context;
import duc.uscript.execution.SymbolBindings;
import duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties;
import duc.uscript.uScript.Symbol;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Map;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Aspect(className = Context.class)
@SuppressWarnings("all")
public class ContextAspect {
  public static Context findCurrentContext(final Context _self) {
    final duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Context findCurrentContext()
    if (_self instanceof duc.uscript.execution.Context){
    	result = duc.uscript.execution.interpreter.modelstate.ContextAspect._privk3_findCurrentContext(_self_, (duc.uscript.execution.Context)_self);
    };
    return (duc.uscript.execution.Context)result;
  }
  
  public static SymbolBindings findBinding(final Context _self, final Symbol symbol) {
    final duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# SymbolBindings findBinding(Symbol)
    if (_self instanceof duc.uscript.execution.Context){
    	result = duc.uscript.execution.interpreter.modelstate.ContextAspect._privk3_findBinding(_self_, (duc.uscript.execution.Context)_self,symbol);
    };
    return (duc.uscript.execution.SymbolBindings)result;
  }
  
  private static Map<Symbol, SymbolBindings> cache(final Context _self) {
    final duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectProperties _self_ = duc.uscript.execution.interpreter.modelstate.ContextAspectContextAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# Map<Symbol, SymbolBindings> cache()
    if (_self instanceof duc.uscript.execution.Context){
    	result = duc.uscript.execution.interpreter.modelstate.ContextAspect._privk3_cache(_self_, (duc.uscript.execution.Context)_self);
    };
    return (java.util.Map<duc.uscript.uScript.Symbol, duc.uscript.execution.SymbolBindings>)result;
  }
  
  protected static Context _privk3_findCurrentContext(final ContextAspectContextAspectProperties _self_, final Context _self) {
    Context _child = _self.getChild();
    boolean _tripleNotEquals = (_child != null);
    if (_tripleNotEquals) {
      return ContextAspect.findCurrentContext(_self.getChild());
    } else {
      return _self;
    }
  }
  
  protected static SymbolBindings _privk3_findBinding(final ContextAspectContextAspectProperties _self_, final Context _self, final Symbol symbol) {
    try {
      boolean _containsKey = ContextAspect.cache(_self).containsKey(symbol);
      boolean _not = (!_containsKey);
      if (_not) {
        final Function1<SymbolBindings, Boolean> _function = (SymbolBindings it) -> {
          Symbol _symbol = it.getSymbol();
          return Boolean.valueOf((_symbol == symbol));
        };
        final SymbolBindings binding = IterableExtensions.<SymbolBindings>findFirst(_self.getBindings(), _function);
        if ((binding != null)) {
          ContextAspect.cache(_self).put(symbol, binding);
        } else {
          Context _parent = _self.getParent();
          boolean _tripleNotEquals = (_parent != null);
          if (_tripleNotEquals) {
            final SymbolBindings binding2 = ContextAspect.findBinding(_self.getParent(), symbol);
            ContextAspect.cache(_self).put(symbol, binding2);
          } else {
            throw new Exception(("No binding for symbol " + symbol));
          }
        }
      }
      return ContextAspect.cache(_self).get(symbol);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected static Map<Symbol, SymbolBindings> _privk3_cache(final ContextAspectContextAspectProperties _self_, final Context _self) {
    try {
    	for (java.lang.reflect.Method m : _self.getClass().getMethods()) {
    		if (m.getName().equals("getCache") &&
    			m.getParameterTypes().length == 0) {
    				Object ret = m.invoke(_self);
    				if (ret != null) {
    					return (java.util.Map) ret;
    				} else {
    					return null;
    				}
    		}
    	}
    } catch (Exception e) {
    	// Chut !
    }
    return _self_.cache;
  }
}
