@Test public void testEmptyName() throws RepositoryException {
  assertEquals("",npMapper.getJcrName(""));
  assertEquals("",npMapper.getOakNameOrNull(""));
  assertEquals("",npMapper.getOakName(""));
}
