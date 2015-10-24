package bc

/**
*  Created by Anthony on 10/22/2015.
*/
class MyByteCodeParser extends ByteCodeParser with ByteCodeValues {
  val vector = Vector[ByteCode]()
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    for(i <- bc.indices) {
      for ((name, code) <- bytecode) {
        if(code.equals(bc(i)) && name.equals("iconst")) vector :+ MyByteCodeFactory.make(bc(i), bc(i + 1).toInt)
        else vector :+ MyByteCodeFactory.make(bc(i))
      }
    }
    vector
    // TODO
  }
}
