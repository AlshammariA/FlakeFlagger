@Test public void fixedLengthUpload_largeBuffers() throws Exception {
  doUpload(TransferKind.FIXED_LENGTH,WriteKind.LARGE_BUFFERS);
}
