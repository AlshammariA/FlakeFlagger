@Test public void testReferenceValue(){
  try {
    valueFactory.createValue("invalidIdentifier",PropertyType.REFERENCE);
    fail("Conversion to REFERENCE value must validate identifier string ");
  }
 catch (  ValueFormatException e) {
  }
}
