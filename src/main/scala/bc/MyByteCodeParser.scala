package bc

/**
*  Created by Anthony on 10/22/2015.
*/
class MyByteCodeParser extends ByteCodeParser with ByteCodeValues {
  var vector = Vector[ByteCode]()
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var iconst = false
    for (i <- bc.indices) {
      if(iconst == false) {
        for ((name, code) <- bytecode) {
          if (bytecode.apply(name).equals(bc(i)) && name.equals("iconst")) {
            vector = vector :+ MyByteCodeFactory.make(bc(i), bc(i + 1).toInt)
            iconst = true
          }
          else if (bytecode.apply(name).equals(bc(i))) {
            vector = vector :+ MyByteCodeFactory.make(bc(i))
            iconst = false
          }
        }
      }
      else iconst = false
    }
    val tmp = vector
    vector = Vector[ByteCode]()
    tmp
    // TODO
  }
}
