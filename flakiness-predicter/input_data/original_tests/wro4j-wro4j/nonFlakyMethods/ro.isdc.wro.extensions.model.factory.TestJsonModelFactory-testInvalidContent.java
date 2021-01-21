@Test(expected=WroRuntimeException.class) public void testInvalidContent(){
  factory=new JsonModelFactory(){
    @Override protected InputStream getModelResourceAsStream() throws IOException {
      return new ByteArrayInputStream("".getBytes());
    }
  }
;
  Assert.assertNull(factory.create());
}
