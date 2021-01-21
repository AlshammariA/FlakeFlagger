@Test public void testLookup(){
  EANManufacturerOrgSupport support=new EANManufacturerOrgSupport();
  assertNull(support.lookupCountryIdentifier("472000"));
  assertEquals("US/CA",support.lookupCountryIdentifier("000000"));
  assertEquals("MO",support.lookupCountryIdentifier("958000"));
  assertEquals("GB",support.lookupCountryIdentifier("500000"));
  assertEquals("GB",support.lookupCountryIdentifier("509000"));
}
