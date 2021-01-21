@Test public void testCopy_doesNotSupportAtomicMove() throws IOException {
  try {
    Files.copy(path("/foo"),path("/bar"),ATOMIC_MOVE);
    fail();
  }
 catch (  UnsupportedOperationException expected) {
  }
}
