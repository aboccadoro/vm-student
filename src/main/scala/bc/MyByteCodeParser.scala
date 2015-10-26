package bc

/**
*  Created by Anthony on 10/22/2015.
*/
class MyByteCodeParser extends ByteCodeParser with ByteCodeValues {
  var vector = Vector[ByteCode]()
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    val tmp = bc
    if (bc.nonEmpty) {
      for ((name, code) <- bytecode) {
        if (bytecode.apply(name).equals(bc.head) && name.equals("iconst")) {
          vector = vector :+ MyByteCodeFactory.make(bc.head, bc(1).toInt)
          parse(tmp.drop(2))
        }
        else if (bytecode.apply(name).equals(bc.head)) {
          vector = vector :+ MyByteCodeFactory.make(bc.head)
          parse(tmp.drop(1))
        }
      }
    }
    println(vector)
    vector
    // TODO
  }
}
