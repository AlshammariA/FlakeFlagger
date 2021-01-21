@Test public void literal() throws RepositoryException {
  Value v=vf.createValue(1);
  Literal l=f.literal(v);
  assertEquals(v,l.getLiteralValue());
  assertEquals("1",l.toString());
  assertEquals("'Joe''s'",f.literal(vf.createValue("Joe's")).toString());
  assertEquals("' - \" - '",f.literal(vf.createValue(" - \" - ")).toString());
}
