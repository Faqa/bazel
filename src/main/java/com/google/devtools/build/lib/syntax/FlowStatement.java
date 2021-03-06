// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.syntax;

import java.io.IOException;

/** A class for flow statements (break, continue, and pass) */
public final class FlowStatement extends Statement {

  private final TokenKind kind; // BREAK | CONTINUE | PASS

  /** @param kind The label of the statement (break, continue, or pass) */
  FlowStatement(TokenKind kind) {
    this.kind = kind;
  }

  public TokenKind getKind() {
    return kind;
  }

  @Override
  public void prettyPrint(Appendable buffer, int indentLevel) throws IOException {
    printIndent(buffer, indentLevel);
    buffer.append(kind.toString()).append('\n');
  }

  @Override
  public String toString() {
    return kind.toString() + "\n";
  }

  @Override
  public void accept(SyntaxTreeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Statement.Kind kind() {
    return Statement.Kind.FLOW;
  }
}
