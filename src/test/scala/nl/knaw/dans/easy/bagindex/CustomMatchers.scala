/**
 * Copyright (C) 2017 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.knaw.dans.easy.bagindex

import org.scalatest.matchers.{ MatchResult, Matcher }

import scala.xml.{ Node, Utility }

trait CustomMatchers {

  // copied from easy-split-multi-deposit
  class EqualTrimmedMatcher(right: Seq[Node]) extends Matcher[Seq[Node]] {
    override def apply(left: Seq[Node]): MatchResult = {
      MatchResult(
        left.zip(right).forall { case (l, r) => Utility.trim(l).toString() == Utility.trim(r).toString() },
        s"$left did not equal $right",
        s"$left did equal $right"
      )
    }
  }
  def equalTrimmed(right: Seq[Node]) = new EqualTrimmedMatcher(right)
}
