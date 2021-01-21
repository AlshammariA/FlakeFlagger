/** 
 * Tests if a microkernel fixture sets the SNNP repository descriptor to false.
 */
@Test public void testMicroKernelSupport() throws Exception {
  NodeStore nodeStore=new KernelNodeStore(new MicroKernelImpl());
  JackrabbitRepository repository=(JackrabbitRepository)new Jcr(nodeStore).createRepository();
  try {
    assertFalse(repository.getDescriptorValue(Repository.OPTION_NODE_AND_PROPERTY_WITH_SAME_NAME_SUPPORTED).getBoolean());
  }
  finally {
    repository.shutdown();
  }
}
