@Test public void chunkedUpload_smallBuffers() throws Exception {
  doUpload(TransferKind.CHUNKED,WriteKind.SMALL_BUFFERS);
}
