package bc

/**
*  Created by Anthony on 10/22/2015.
*/

/**
 * MyByteCodeParser parses a Vector[Byte] into a Vector[ByteCode] based
 * on the instructions denoted by the Bytes. A Vector[Byte] is useful
 * for the adapter to parse a file or string into a Vector[ByteCode] using
 * MyByteCodeParser.
 */
class MyByteCodeParser extends ByteCodeParser with ByteCodeValues {
  var vector = Vector[ByteCode]()
  def parse(bc: Vector[Byte]): Vector[ByteCode] = {
    var iconst = false
    for (i <- bc.indices) {
      if(!iconst) {
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
  }
}
