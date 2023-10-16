# Spring GraphQL support test

~~**233.9102 state:**~~ - FIXED

~~1. install GraphQL plugin:~~
 ~~- endpoints are detected from schema~~
 ~~- no other support~~
 ~~- HTTP Client is broken (see `graphql.http`)~~

~~2. install Spring GraphQL: everything is broken~~

- Schema files:
  - no navigation to Endpoints https://youtrack.jetbrains.com/issue/IDEA-334113

- No suggestion to install/enable Spring GraphQL plugin https://youtrack.jetbrains.com/issue/IDEA-334633

- Incorrect GraphQL requests generating for mappings:
  - add the `spring.graphql.path` value ("/graphql" if not set) path to request automatically https://youtrack.jetbrains.com/issue/IDEA-334939
  - redundant `()` after query name for parameter-less methods https://youtrack.jetbrains.com/issue/IDEA-334940
  - in case of parameters: query parameter var is not declared https://youtrack.jetbrains.com/issue/IDEA-334945
  - nothing is generated in the Endpoints view https://youtrack.jetbrains.com/issue/IDEA-334964
  

- mapping annotations:
  - rename doesn't work correctly for explicit #value/#field value in @SchemaMapping (and derived annotations) https://youtrack.jetbrains.com/issue/IDEA-334970
  - no navigation from mappings to Endpoints https://youtrack.jetbrains.com/issue/IDEA-334972