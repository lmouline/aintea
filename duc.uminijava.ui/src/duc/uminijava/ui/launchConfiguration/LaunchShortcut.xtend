package duc.uminijava.ui.launchConfiguration

import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorPart
import org.eclipse.core.runtime.IAdaptable
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.core.resources.IFile
import org.eclipse.jface.viewers.TreePath
import duc.uminijava.minirunner.StandaloneExecutor
import java.io.OutputStream
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleManager
import org.eclipse.ui.console.IConsole
import org.eclipse.ui.part.FileEditorInput

class LaunchShortcut implements ILaunchShortcut {
	static final String CONSOLE_NAME = "UminiJava_Console"
	
	override launch(ISelection selection, String mode) {
		val TreeSelection treeSelection = selection as TreeSelection;
        val TreePath[] treePaths = treeSelection.getPaths();
        val TreePath treePath = treePaths.get(0);
       
        val Object lastSegmentObj = treePath.getLastSegment();
                
        if(lastSegmentObj instanceof IAdaptable) {
	        val IFile file = (lastSegmentObj as IAdaptable).getAdapter(IFile);
	        if(file !== null) {
	        	execute(file.rawLocation.toOSString)
            }
        }
	}
	
	override launch(IEditorPart editor, String mode) {
		val FileEditorInput fileEditor = editor.editorInput as FileEditorInput
		val String filePath = fileEditor.file.location.toOSString
		execute(filePath)
	}
	
	def execute(String filePath) {
		if(filePath !== null) {
			val out = getConsoleOutputStream()
			StandaloneExecutor.execute(filePath, out)
			out.flush
			out.close
		} 
	}
		
	private def OutputStream getConsoleOutputStream() {
      val ConsolePlugin plugin = ConsolePlugin.getDefault();
      val IConsoleManager conMan = plugin.getConsoleManager();
      val IConsole[] existing = conMan.getConsoles();
      
      var  MessageConsole console;
      
      for (var i = 0; i < existing.length; i++) {
         if (CONSOLE_NAME.equals(existing.get(i).getName())) {
            console = existing.get(i) as MessageConsole;
            console.clearConsole
         }
       }
       if (console === null) {
       		console = new MessageConsole(CONSOLE_NAME, null);
       		conMan.addConsoles(#[console]);
       }
       
       console.newOutputStream
   }
	
	
	
	
	
	
	
	
}