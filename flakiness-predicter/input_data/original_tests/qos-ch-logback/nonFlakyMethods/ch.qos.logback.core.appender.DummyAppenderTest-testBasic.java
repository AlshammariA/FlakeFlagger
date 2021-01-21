@Test public void testBasic() throws IOException {
  Encoder<Object> encoder=new DummyEncoder<Object>();
  encoder.init(baos);
  da.setEncoder(encoder);
  da.start();
  da.doAppend(new Object());
  assertEquals(DummyLayout.DUMMY,baos.toString());
}
