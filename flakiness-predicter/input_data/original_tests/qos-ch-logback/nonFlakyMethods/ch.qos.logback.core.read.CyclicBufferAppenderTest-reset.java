@Test public void reset(){
  cyclicBufferAppender.append("foobar");
  assertEquals(1,cyclicBufferAppender.getLength());
  cyclicBufferAppender.reset();
  assertEquals(0,cyclicBufferAppender.getLength());
}
