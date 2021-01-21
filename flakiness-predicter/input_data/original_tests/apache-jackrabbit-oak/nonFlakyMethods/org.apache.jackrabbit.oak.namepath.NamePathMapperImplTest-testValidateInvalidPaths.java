@Test public void testValidateInvalidPaths(){
  assertFalse(JcrPathParser.validate("//"));
  assertFalse(JcrPathParser.validate("/foo//"));
  assertFalse(JcrPathParser.validate("/..//"));
  assertFalse(JcrPathParser.validate("/.."));
  assertFalse(JcrPathParser.validate("/foo/../.."));
}
