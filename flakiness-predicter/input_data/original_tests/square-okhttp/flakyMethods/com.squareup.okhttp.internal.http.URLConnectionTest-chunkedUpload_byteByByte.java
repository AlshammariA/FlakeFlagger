@Test public void chunkedUpload_byteByByte() throws Exception {
  doUpload(TransferKind.CHUNKED,WriteKind.BYTE_BY_BYTE);
}
