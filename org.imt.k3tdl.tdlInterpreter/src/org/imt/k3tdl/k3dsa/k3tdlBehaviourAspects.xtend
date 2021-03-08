package org.imt.k3tdl.k3dsa

import fr.inria.diverse.k3.al.annotationprocessor.Aspect






import fr.inria.diverse.k3.al.annotationprocessor.Step
import fr.inria.diverse.k3.al.annotationprocessor.OverrideAspectMethod

import org.etsi.mts.tdl.Interaction
import org.etsi.mts.tdl.Behaviour
import org.etsi.mts.tdl.AtomicBehaviour
import org.etsi.mts.tdl.CombinedBehaviour
import org.etsi.mts.tdl.PeriodicBehaviour
import org.etsi.mts.tdl.ExceptionalBehaviour
import org.etsi.mts.tdl.ActionBehaviour
import org.etsi.mts.tdl.VerdictAssignment
import org.etsi.mts.tdl.Stop
import org.etsi.mts.tdl.Break
import org.etsi.mts.tdl.TestDescriptionReference
import org.etsi.mts.tdl.TimerOperation
import org.etsi.mts.tdl.TimeOperation
import org.etsi.mts.tdl.Assertion
import org.etsi.mts.tdl.Assignment
import org.etsi.mts.tdl.InlineAction
import org.etsi.mts.tdl.ActionReference
import org.etsi.mts.tdl.TimerStart
import org.etsi.mts.tdl.ProcedureCall
import org.etsi.mts.tdl.Message
import org.etsi.mts.tdl.TimerStop
import org.etsi.mts.tdl.TimeOut
import org.etsi.mts.tdl.Wait
import org.etsi.mts.tdl.Quiescence
import org.etsi.mts.tdl.SingleCombinedBehaviour
import org.etsi.mts.tdl.MultipleCombinedBehaviour
import org.etsi.mts.tdl.BoundedLoopBehaviour
import org.etsi.mts.tdl.UnboundedLoopBehaviour
import org.etsi.mts.tdl.CompoundBehaviour
import org.etsi.mts.tdl.OptionalBehaviour
import org.etsi.mts.tdl.ConditionalBehaviour
import org.etsi.mts.tdl.AlternativeBehaviour
import org.etsi.mts.tdl.ParallelBehaviour
import org.etsi.mts.tdl.DefaultBehaviour
import org.etsi.mts.tdl.InterruptBehaviour
import org.etsi.mts.tdl.Block
import org.etsi.mts.tdl.BehaviourDescription
import static extension org.imt.k3tdl.k3dsa.BehaviourAspect.*
import static extension org.imt.k3tdl.k3dsa.BlockAspect.*
import static extension org.imt.k3tdl.k3dsa.GateInstanceAspect.*
import static extension org.imt.k3tdl.k3dsa.TestDescriptionAspect.*
import static extension org.imt.k3tdl.k3dsa.TestConfigurationAspect.*
import org.etsi.mts.tdl.Target

@Aspect (className = BehaviourDescription)
class BehaviourDescriptionAspect{
	@Step
	def void callBehavior(){
		_self.behaviour.performBehavior()
	}
}
@Aspect (className = Behaviour)
class BehaviourAspect{
	public Behaviour enabledBehaviour;
	@Step
	def void performBehavior(){
		_self.enabledBehaviour = _self
	}
}
@Aspect (className = AtomicBehaviour)
class AtomicBehaviourAspect extends BehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = CombinedBehaviour)
class CombinedBehaviourAspect extends BehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = PeriodicBehaviour)
class PeriodicBehaviourAspect extends BehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = ExceptionalBehaviour)
class ExceptionalBehaviourAspect extends BehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = ActionBehaviour)
class ActionBehaviourAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = VerdictAssignment)
class VerdictAssignmentAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Stop)
class StopAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Break)
class BreakAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = TestDescriptionReference)
class TestDescriptionReferenceAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Interaction)
class InteractoinAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = TimerOperation)
class TimerOperationAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = TimeOperation)
class TimeOperationAspect extends AtomicBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Assertion)
class AssertionAspect extends ActionBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Assignment)
class AssignmentAspect extends ActionBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = InlineAction)
class InlineActionAspect extends ActionBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = ActionReference)
class ActionReferenceAspect extends ActionBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = ProcedureCall)
class ProcedureCallAspect extends InteractoinAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Message)
class MessageAspect extends InteractoinAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		for (Target t: _self.target){
			t.targetGate.gate.DSLPath = _self.parentTestDescription.testConfiguration.DSLPath
			t.targetGate.gate.MUTPath = _self.parentTestDescription.testConfiguration.MUTPath
			if (_self.sourceGate.component.role.toString == "SUT"){
				//when the SUT component sends an argument, it is actually an assertion that have to be checked
				_self.sourceGate.gate.setLauncher(_self.parentTestDescription.launcher)
				val result = _self.sourceGate.gate.assertArgument(_self.argument)
				_self.parentTestDescription.verdict.put(_self, result)
			}else{//the argument has to be sent to the MUT
				t.targetGate.gate.setLauncher(_self.parentTestDescription.launcher)
				t.targetGate.gate.sendArgument2sut(_self.argument)
			}
		}	
	}
}
@Aspect (className = TimerStart)
class TimerStartAspect extends TimerOperationAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = TimerStop)
class TimerStopAspect extends TimerOperationAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = TimeOut)
class TimeOutAspect extends TimerOperationAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Wait)
class WaitAspect extends TimeOperationAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = Quiescence)
class QuiescenceAspect extends TimeOperationAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = SingleCombinedBehaviour)
class SingleCombinedBehaviourAspect extends CombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = MultipleCombinedBehaviour)
class MultipleCombinedBehaviourAspect extends CombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = BoundedLoopBehaviour)
class BoundedLoopBehaviourAspect extends SingleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = UnboundedLoopBehaviour)
class UnBoundedLoopBehaviourAspect extends SingleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = CompoundBehaviour)
class CompoundBehaviourAspect extends SingleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = OptionalBehaviour)
class OptionalBehaviourAspect extends SingleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = ConditionalBehaviour)
class ConditionalBehaviourAspect extends MultipleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = AlternativeBehaviour)
class AlternativeBehaviourAspect extends MultipleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		for (Block innerBlock : _self.block){
			for (Behaviour b :innerBlock.behaviour){
				_self.enabledBehaviour = b
				b.performBehavior()
			}
		}
	}
}
@Aspect (className = ParallelBehaviour)
class ParallelBehaviourAspect extends MultipleCombinedBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
	}
}
@Aspect (className = DefaultBehaviour)
class DefaultBehaviourAspect extends ExceptionalBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = InterruptBehaviour)
class InterruptBehaviourAspect extends ExceptionalBehaviourAspect{
	@Step
	@OverrideAspectMethod
	def void performBehavior(){
		_self.block.traverseBlock()
	}
}
@Aspect (className = Block)
class BlockAspect{
	public String blockStatus
	@Step
	def void traverseBlock(){
		_self.blockStatus = "Activated"
		for (Behaviour b:_self.behaviour){
			b.performBehavior()
		}
	}
}