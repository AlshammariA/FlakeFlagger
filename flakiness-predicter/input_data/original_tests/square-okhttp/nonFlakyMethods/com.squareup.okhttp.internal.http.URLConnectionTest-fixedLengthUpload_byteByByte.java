@Test public void fixedLengthUpload_byteByByte() throws Exception {
  doUpload(TransferKind.FIXED_LENGTH,WriteKind.BYTE_BY_BYTE);
}
