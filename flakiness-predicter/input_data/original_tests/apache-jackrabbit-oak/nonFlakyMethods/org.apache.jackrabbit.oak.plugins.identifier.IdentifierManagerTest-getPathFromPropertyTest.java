@Test public void getPathFromPropertyTest(){
  assertEquals("/y",identifierManager.getPath(createReferenceProperty(UUID_Y)));
  assertEquals(PATH_Z1,identifierManager.getPath(createReferenceProperty(UUID_Z1)));
  assertNull(identifierManager.getPath(createReferenceProperty(ID_NON_EXISTING)));
  assertNull(identifierManager.getPath(createReferenceProperty(ID_INVALID)));
  try {
    identifierManager.getPath(PropertyStates.createProperty("any","any"));
    fail("Expected IllegalArgumentException");
  }
 catch (  IllegalArgumentException expected) {
  }
}
