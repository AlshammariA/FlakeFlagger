@Test public void shouldHashWithConfiguredStrategy() throws Exception {
  Assert.assertEquals("8151325dcdbae9e0ff95f9f9658432dbedfdb209",victim.getHash(new ByteArrayInputStream("sample".getBytes())));
}
