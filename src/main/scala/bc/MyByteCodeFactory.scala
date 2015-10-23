package bc

/**
*  Created by Anthony on 10/22/2015.
*/
trait MyByteCodeFactory extends ByteCodeFactory {
  def make(byte: Byte, args: Int*): ByteCode = ???
  // TODO
}
