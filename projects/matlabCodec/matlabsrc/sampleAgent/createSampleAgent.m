sampleAgentStruct.init='sampleAgent_init';
sampleAgentStruct.start='sampleAgent_start';
sampleAgentStruct.step='sampleAgent_step';
sampleAgentStruct.end='sampleAgent_end';
sampleAgentStruct.message='sampleAgent_message';
sampleAgentStruct.cleanup='sampleAgent_cleanup';
sampleAgentStruct.freeze='sampleAgent_freeze';
%Do this for all of the agent functions

theAgentCell=agentCellFromStruct(sampleAgentStruct);

theJavaAgent=org.rlcommunity.rlglue.ext.codecs.matlab.MatlabAgentCodec(theAgentCell);