@Test public void chunkedUpload_largeBuffers() throws Exception {
  doUpload(TransferKind.CHUNKED,WriteKind.LARGE_BUFFERS);
}
