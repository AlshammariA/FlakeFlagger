/** 
 * Tests if a nodestore fixture sets the SNNP repository descriptor to true.
 */
@Test public void testNodeStoreSupport() throws Exception {
  NodeStore nodeStore=NodeStoreFixture.SEGMENT_MK.createNodeStore();
  JackrabbitRepository repository=(JackrabbitRepository)new Jcr(nodeStore).createRepository();
  try {
    assertTrue(repository.getDescriptorValue(Repository.OPTION_NODE_AND_PROPERTY_WITH_SAME_NAME_SUPPORTED).getBoolean());
  }
  finally {
    repository.shutdown();
  }
}
