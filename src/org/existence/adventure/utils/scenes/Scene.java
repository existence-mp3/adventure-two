package org.existence.adventure.utils.scenes;

/**
 * Framework class for creating scenes in the game
 */
public class Scene {

    /**
     * The dialogue in the scene
     */
    public String[] dialogueText;
    /**
     * The next dialogue to be printed out
     */
    public Dialogue dialogue;
    /**
     * The list value of the next dialogue to be printed out
     */
    public int nextDialogueValue;

    /**
     * Defines a new Scene object with the given list of dialogue included and a
     * specified dialogue to start on
     * 
     * @param start        List value of the dialogue to start on
     * @param dialogueText List of dialogue included within the scene
     */
    public Scene(int start, String... dialogueText) {
        this.dialogueText = dialogueText;
        nextDialogueValue = start;
    }

    /**
     * Defines a new Scene object with the given list of dialogue included
     * 
     * @param dialogue List of dialogue included within the scene
     */
    public Scene(String... dialogue) {
        this(0, dialogue);
    }

    /**
     * Checks if the known next dialogue is the same as the expected one. If not,
     * changes it to the expected one
     */
    public void verifyCurrentDialogue() {
        if (dialogueText[nextDialogueValue] == dialogue.getValue()) {
            dialogue.setValue(dialogueText[nextDialogueValue]);
        }
    }

    /**
     * Changes the active dialogue to the next one in the given list
     */
    public void advanceDialogue() {
        nextDialogueValue++;
    }

    /**
     * Changes the active dialogue to a specified one in the given list
     * 
     * @param target The list value of the dialogue to advance to
     */
    public void advanceDialogue(int target) {
        nextDialogueValue = target;
    }

    /**
     * Verifies that the current dialogue is the expected one and then prints out
     * the value of the corrected dialogue
     */
    public void activateDialogue() {
        verifyCurrentDialogue();
        dialogue.print();
    }

}
