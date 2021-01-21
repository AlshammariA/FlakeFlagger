/** 
 * testing for asserting the right comparison behaviour of the custom class
 */
@Test public void valuePathTupleComparison(){
  try {
    new ValuePathTuple("value","path").compareTo(null);
    fail("It should have raised a NPE");
  }
 catch (  NullPointerException e) {
  }
  assertEquals(0,(new ValuePathTuple("value","path")).compareTo(new ValuePathTuple("value","path")));
  assertEquals(-1,(new ValuePathTuple("value","path")).compareTo(new ValuePathTuple("value1","path")));
  assertEquals(-1,(new ValuePathTuple("value1","path")).compareTo(new ValuePathTuple("value1","path1")));
  assertEquals(1,(new ValuePathTuple("value1","path")).compareTo(new ValuePathTuple("value","path")));
  assertEquals(1,(new ValuePathTuple("value1","path1")).compareTo(new ValuePathTuple("value1","path")));
  assertEquals(-1,(new ValuePathTuple("value000","/test/n1")).compareTo(new ValuePathTuple("value001","/test/n0")));
  assertEquals(1,(new ValuePathTuple("value001","/test/n0")).compareTo(new ValuePathTuple("value000","/test/n1")));
}
