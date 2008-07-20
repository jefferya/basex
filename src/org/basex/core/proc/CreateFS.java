package org.basex.core.proc;

import org.basex.build.fs.FSParser;
import org.basex.core.Prop;
import org.basex.core.Commands.COMMANDS;
import org.basex.core.Commands.CREATE;
import org.basex.io.IO;

/**
 * Creates a new filesystem mapping.
 * 
 * @author Workgroup DBIS, University of Konstanz 2005-08, ISC License
 * @author Christian Gruen
 */
public final class CreateFS extends ACreate {
  /**
   * Constructor.
   * @param p database path
   * @param n database name
   */
  public CreateFS(final String p, final String n) {
    super(STANDARD, p, n);
  }
  
  @Override
  protected boolean exec() {
    final IO f = new IO(args[0]);
    final String db = args[1] == null ? f.dbname() : args[1];
    Prop.chop = true;
    Prop.entity = true;
    Prop.mainmem = false;
    return build(new FSParser(f), db);
  }
  
  @Override
  public String toString() {
    return COMMANDS.CREATE.name() + " " + CREATE.FS + args();
  }
}
