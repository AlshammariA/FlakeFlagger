@Test(expected=IllegalArgumentException.class) public void testIllegalConstructorNullByteArray() throws Exception {
  new ByteArrayEntity(null);
}
