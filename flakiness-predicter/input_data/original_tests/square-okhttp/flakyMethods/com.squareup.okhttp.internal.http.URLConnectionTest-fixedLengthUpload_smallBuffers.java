@Test public void fixedLengthUpload_smallBuffers() throws Exception {
  doUpload(TransferKind.FIXED_LENGTH,WriteKind.SMALL_BUFFERS);
}
