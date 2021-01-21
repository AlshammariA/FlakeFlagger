@Test public void processSampleContentWithManyOptions() throws Exception {
  cssLint.setOptions("ids,adjoining-classes,box-model,box-sizing,compatible-vendor-prefixes,display-property-grouping,duplicate-background-images,duplicate-properties,empty-rules,errors,fallback-colors,floats,font-faces,font-sizes,gradients,import,important,known-properties,outline-none,overqualified-elements,qualified-headings,regex-selectors,rules-count,shorthand,text-indent,unique-headings,universal-selector,unqualified-attributes,vendor-prefix,zero-units");
  try {
    final URL url=getClass().getResource("sample/content.css");
    cssLint.validate(IOUtils.toString(new FileInputStream(url.getFile())));
    Assert.fail("should have failed!");
  }
 catch (  final CssLintException e) {
    Assert.assertEquals(30,e.getErrors().size());
  }
}
