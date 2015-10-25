package bc

/**
*  Created by Anthony on 10/22/2015.
*/
class MyByteCodeParser extends ByteCodeParser with ByteCodeValues {
  var vector = Vector[ByteCode]()
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    val tmp = bc
    if (tmp.nonEmpty)
      for ((name, code) <- bytecode) {
        if(bytecode.apply(name).equals(bc(0)) && name.equals("iconst")) {
          vector :+ MyByteCodeFactory.make(bc(0), bc(1))
          parse(tmp.drop(2))
        }
        else if(bytecode.apply(name).equals(bc(0))) {
          vector = vector :+ MyByteCodeFactory.make(bc(0))
          parse(tmp.drop(1))
        }
      }
    vector
    // TODO
  }
}
