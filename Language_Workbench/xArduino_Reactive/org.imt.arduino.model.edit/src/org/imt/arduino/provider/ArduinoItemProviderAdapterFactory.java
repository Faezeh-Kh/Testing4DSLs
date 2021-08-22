/**
 */
package org.imt.arduino.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.imt.arduino.util.ArduinoAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArduinoItemProviderAdapterFactory extends ArduinoAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArduinoItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.DigitalPin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DigitalPinItemProvider digitalPinItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.DigitalPin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDigitalPinAdapter() {
		if (digitalPinItemProvider == null) {
			digitalPinItemProvider = new DigitalPinItemProvider(this);
		}

		return digitalPinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.AnalogPin} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalogPinItemProvider analogPinItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.AnalogPin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAnalogPinAdapter() {
		if (analogPinItemProvider == null) {
			analogPinItemProvider = new AnalogPinItemProvider(this);
		}

		return analogPinItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Sketch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SketchItemProvider sketchItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Sketch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSketchAdapter() {
		if (sketchItemProvider == null) {
			sketchItemProvider = new SketchItemProvider(this);
		}

		return sketchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Project} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectItemProvider projectItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Project}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProjectAdapter() {
		if (projectItemProvider == null) {
			projectItemProvider = new ProjectItemProvider(this);
		}

		return projectItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.ModuleAssignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModuleAssignmentItemProvider moduleAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.ModuleAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createModuleAssignmentAdapter() {
		if (moduleAssignmentItemProvider == null) {
			moduleAssignmentItemProvider = new ModuleAssignmentItemProvider(this);
		}

		return moduleAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Delay} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DelayItemProvider delayItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Delay}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDelayAdapter() {
		if (delayItemProvider == null) {
			delayItemProvider = new DelayItemProvider(this);
		}

		return delayItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Repeat} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepeatItemProvider repeatItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Repeat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRepeatAdapter() {
		if (repeatItemProvider == null) {
			repeatItemProvider = new RepeatItemProvider(this);
		}

		return repeatItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.While} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileItemProvider whileItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.While}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWhileAdapter() {
		if (whileItemProvider == null) {
			whileItemProvider = new WhileItemProvider(this);
		}

		return whileItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.VariableAssignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAssignmentItemProvider variableAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.VariableAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVariableAssignmentAdapter() {
		if (variableAssignmentItemProvider == null) {
			variableAssignmentItemProvider = new VariableAssignmentItemProvider(this);
		}

		return variableAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BinaryIntegerExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryIntegerExpressionItemProvider binaryIntegerExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BinaryIntegerExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBinaryIntegerExpressionAdapter() {
		if (binaryIntegerExpressionItemProvider == null) {
			binaryIntegerExpressionItemProvider = new BinaryIntegerExpressionItemProvider(this);
		}

		return binaryIntegerExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BinaryBooleanExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryBooleanExpressionItemProvider binaryBooleanExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BinaryBooleanExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBinaryBooleanExpressionAdapter() {
		if (binaryBooleanExpressionItemProvider == null) {
			binaryBooleanExpressionItemProvider = new BinaryBooleanExpressionItemProvider(this);
		}

		return binaryBooleanExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.If} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfItemProvider ifItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.If}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIfAdapter() {
		if (ifItemProvider == null) {
			ifItemProvider = new IfItemProvider(this);
		}

		return ifItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.IntegerConstant} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerConstantItemProvider integerConstantItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.IntegerConstant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerConstantAdapter() {
		if (integerConstantItemProvider == null) {
			integerConstantItemProvider = new IntegerConstantItemProvider(this);
		}

		return integerConstantItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BooleanConstant} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanConstantItemProvider booleanConstantItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BooleanConstant}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanConstantAdapter() {
		if (booleanConstantItemProvider == null) {
			booleanConstantItemProvider = new BooleanConstantItemProvider(this);
		}

		return booleanConstantItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.IntegerVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerVariableItemProvider integerVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.IntegerVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerVariableAdapter() {
		if (integerVariableItemProvider == null) {
			integerVariableItemProvider = new IntegerVariableItemProvider(this);
		}

		return integerVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BooleanVariable} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableItemProvider booleanVariableItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BooleanVariable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanVariableAdapter() {
		if (booleanVariableItemProvider == null) {
			booleanVariableItemProvider = new BooleanVariableItemProvider(this);
		}

		return booleanVariableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BooleanModuleGet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanModuleGetItemProvider booleanModuleGetItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BooleanModuleGet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanModuleGetAdapter() {
		if (booleanModuleGetItemProvider == null) {
			booleanModuleGetItemProvider = new BooleanModuleGetItemProvider(this);
		}

		return booleanModuleGetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.IntegerModuleGet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerModuleGetItemProvider integerModuleGetItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.IntegerModuleGet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerModuleGetAdapter() {
		if (integerModuleGetItemProvider == null) {
			integerModuleGetItemProvider = new IntegerModuleGetItemProvider(this);
		}

		return integerModuleGetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.UnaryBooleanExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryBooleanExpressionItemProvider unaryBooleanExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.UnaryBooleanExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnaryBooleanExpressionAdapter() {
		if (unaryBooleanExpressionItemProvider == null) {
			unaryBooleanExpressionItemProvider = new UnaryBooleanExpressionItemProvider(this);
		}

		return unaryBooleanExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.UnaryIntegerExpression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryIntegerExpressionItemProvider unaryIntegerExpressionItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.UnaryIntegerExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnaryIntegerExpressionAdapter() {
		if (unaryIntegerExpressionItemProvider == null) {
			unaryIntegerExpressionItemProvider = new UnaryIntegerExpressionItemProvider(this);
		}

		return unaryIntegerExpressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.VariableDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationItemProvider variableDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVariableDeclarationAdapter() {
		if (variableDeclarationItemProvider == null) {
			variableDeclarationItemProvider = new VariableDeclarationItemProvider(this);
		}

		return variableDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.IntegerVariableRef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerVariableRefItemProvider integerVariableRefItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.IntegerVariableRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIntegerVariableRefAdapter() {
		if (integerVariableRefItemProvider == null) {
			integerVariableRefItemProvider = new IntegerVariableRefItemProvider(this);
		}

		return integerVariableRefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.LED} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LEDItemProvider ledItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.LED}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLEDAdapter() {
		if (ledItemProvider == null) {
			ledItemProvider = new LEDItemProvider(this);
		}

		return ledItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.PushButton} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PushButtonItemProvider pushButtonItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.PushButton}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPushButtonAdapter() {
		if (pushButtonItemProvider == null) {
			pushButtonItemProvider = new PushButtonItemProvider(this);
		}

		return pushButtonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Buzzer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BuzzerItemProvider buzzerItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Buzzer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBuzzerAdapter() {
		if (buzzerItemProvider == null) {
			buzzerItemProvider = new BuzzerItemProvider(this);
		}

		return buzzerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.RotationSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RotationSensorItemProvider rotationSensorItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.RotationSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRotationSensorAdapter() {
		if (rotationSensorItemProvider == null) {
			rotationSensorItemProvider = new RotationSensorItemProvider(this);
		}

		return rotationSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.MicroServo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MicroServoItemProvider microServoItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.MicroServo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMicroServoAdapter() {
		if (microServoItemProvider == null) {
			microServoItemProvider = new MicroServoItemProvider(this);
		}

		return microServoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.InfraRedSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InfraRedSensorItemProvider infraRedSensorItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.InfraRedSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInfraRedSensorAdapter() {
		if (infraRedSensorItemProvider == null) {
			infraRedSensorItemProvider = new InfraRedSensorItemProvider(this);
		}

		return infraRedSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.AmbientLightSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AmbientLightSensorItemProvider ambientLightSensorItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.AmbientLightSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAmbientLightSensorAdapter() {
		if (ambientLightSensorItemProvider == null) {
			ambientLightSensorItemProvider = new AmbientLightSensorItemProvider(this);
		}

		return ambientLightSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.SoundSensor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoundSensorItemProvider soundSensorItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.SoundSensor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSoundSensorAdapter() {
		if (soundSensorItemProvider == null) {
			soundSensorItemProvider = new SoundSensorItemProvider(this);
		}

		return soundSensorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Fan} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FanItemProvider fanItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Fan}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFanAdapter() {
		if (fanItemProvider == null) {
			fanItemProvider = new FanItemProvider(this);
		}

		return fanItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.MusicPlayer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MusicPlayerItemProvider musicPlayerItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.MusicPlayer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMusicPlayerAdapter() {
		if (musicPlayerItemProvider == null) {
			musicPlayerItemProvider = new MusicPlayerItemProvider(this);
		}

		return musicPlayerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.WaitFor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WaitForItemProvider waitForItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.WaitFor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWaitForAdapter() {
		if (waitForItemProvider == null) {
			waitForItemProvider = new WaitForItemProvider(this);
		}

		return waitForItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.Block} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockItemProvider blockItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.Block}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBlockAdapter() {
		if (blockItemProvider == null) {
			blockItemProvider = new BlockItemProvider(this);
		}

		return blockItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.ArduinoBoard} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArduinoBoardItemProvider arduinoBoardItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.ArduinoBoard}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArduinoBoardAdapter() {
		if (arduinoBoardItemProvider == null) {
			arduinoBoardItemProvider = new ArduinoBoardItemProvider(this);
		}

		return arduinoBoardItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BooleanVariableRef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanVariableRefItemProvider booleanVariableRefItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BooleanVariableRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBooleanVariableRefAdapter() {
		if (booleanVariableRefItemProvider == null) {
			booleanVariableRefItemProvider = new BooleanVariableRefItemProvider(this);
		}

		return booleanVariableRefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.imt.arduino.BluetoothTransceiver} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BluetoothTransceiverItemProvider bluetoothTransceiverItemProvider;

	/**
	 * This creates an adapter for a {@link org.imt.arduino.BluetoothTransceiver}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBluetoothTransceiverAdapter() {
		if (bluetoothTransceiverItemProvider == null) {
			bluetoothTransceiverItemProvider = new BluetoothTransceiverItemProvider(this);
		}

		return bluetoothTransceiverItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (digitalPinItemProvider != null) digitalPinItemProvider.dispose();
		if (analogPinItemProvider != null) analogPinItemProvider.dispose();
		if (sketchItemProvider != null) sketchItemProvider.dispose();
		if (projectItemProvider != null) projectItemProvider.dispose();
		if (moduleAssignmentItemProvider != null) moduleAssignmentItemProvider.dispose();
		if (delayItemProvider != null) delayItemProvider.dispose();
		if (repeatItemProvider != null) repeatItemProvider.dispose();
		if (whileItemProvider != null) whileItemProvider.dispose();
		if (variableAssignmentItemProvider != null) variableAssignmentItemProvider.dispose();
		if (binaryIntegerExpressionItemProvider != null) binaryIntegerExpressionItemProvider.dispose();
		if (binaryBooleanExpressionItemProvider != null) binaryBooleanExpressionItemProvider.dispose();
		if (ifItemProvider != null) ifItemProvider.dispose();
		if (integerConstantItemProvider != null) integerConstantItemProvider.dispose();
		if (booleanConstantItemProvider != null) booleanConstantItemProvider.dispose();
		if (integerVariableItemProvider != null) integerVariableItemProvider.dispose();
		if (booleanVariableItemProvider != null) booleanVariableItemProvider.dispose();
		if (booleanModuleGetItemProvider != null) booleanModuleGetItemProvider.dispose();
		if (integerModuleGetItemProvider != null) integerModuleGetItemProvider.dispose();
		if (unaryBooleanExpressionItemProvider != null) unaryBooleanExpressionItemProvider.dispose();
		if (unaryIntegerExpressionItemProvider != null) unaryIntegerExpressionItemProvider.dispose();
		if (variableDeclarationItemProvider != null) variableDeclarationItemProvider.dispose();
		if (integerVariableRefItemProvider != null) integerVariableRefItemProvider.dispose();
		if (ledItemProvider != null) ledItemProvider.dispose();
		if (pushButtonItemProvider != null) pushButtonItemProvider.dispose();
		if (buzzerItemProvider != null) buzzerItemProvider.dispose();
		if (rotationSensorItemProvider != null) rotationSensorItemProvider.dispose();
		if (microServoItemProvider != null) microServoItemProvider.dispose();
		if (infraRedSensorItemProvider != null) infraRedSensorItemProvider.dispose();
		if (ambientLightSensorItemProvider != null) ambientLightSensorItemProvider.dispose();
		if (soundSensorItemProvider != null) soundSensorItemProvider.dispose();
		if (fanItemProvider != null) fanItemProvider.dispose();
		if (musicPlayerItemProvider != null) musicPlayerItemProvider.dispose();
		if (waitForItemProvider != null) waitForItemProvider.dispose();
		if (blockItemProvider != null) blockItemProvider.dispose();
		if (arduinoBoardItemProvider != null) arduinoBoardItemProvider.dispose();
		if (booleanVariableRefItemProvider != null) booleanVariableRefItemProvider.dispose();
		if (bluetoothTransceiverItemProvider != null) bluetoothTransceiverItemProvider.dispose();
	}

}
