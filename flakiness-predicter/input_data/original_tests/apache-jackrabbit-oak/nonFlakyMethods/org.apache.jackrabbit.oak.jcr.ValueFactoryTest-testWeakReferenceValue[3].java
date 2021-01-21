@Test public void testWeakReferenceValue(){
  try {
    valueFactory.createValue("invalidIdentifier",PropertyType.WEAKREFERENCE);
    fail("Conversion to WEAK_REFERENCE value must validate identifier string ");
  }
 catch (  ValueFormatException e) {
  }
}
