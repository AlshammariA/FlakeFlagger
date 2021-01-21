@Test public void testInvalidCharArrayAppend() throws Exception {
  CharArrayBuffer buffer=new CharArrayBuffer(4);
  buffer.append((char[])null,0,0);
  char[] tmp=new char[]{'1','2','3','4'};
  try {
    buffer.append(tmp,-1,0);
    Assert.fail("IndexOutOfBoundsException should have been thrown");
  }
 catch (  IndexOutOfBoundsException ex) {
  }
  try {
    buffer.append(tmp,0,-1);
    Assert.fail("IndexOutOfBoundsException should have been thrown");
  }
 catch (  IndexOutOfBoundsException ex) {
  }
  try {
    buffer.append(tmp,0,8);
    Assert.fail("IndexOutOfBoundsException should have been thrown");
  }
 catch (  IndexOutOfBoundsException ex) {
  }
  try {
    buffer.append(tmp,10,Integer.MAX_VALUE);
    Assert.fail("IndexOutOfBoundsException should have been thrown");
  }
 catch (  IndexOutOfBoundsException ex) {
  }
  try {
    buffer.append(tmp,2,4);
    Assert.fail("IndexOutOfBoundsException should have been thrown");
  }
 catch (  IndexOutOfBoundsException ex) {
  }
}
