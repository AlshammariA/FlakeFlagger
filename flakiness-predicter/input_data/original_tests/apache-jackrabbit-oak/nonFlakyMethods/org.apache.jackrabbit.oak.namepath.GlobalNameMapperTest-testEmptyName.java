@Test public void testEmptyName() throws RepositoryException {
  assertEquals("",mapper.getJcrName(""));
  assertEquals("",mapper.getOakNameOrNull(""));
  assertEquals("",mapper.getOakName(""));
}
