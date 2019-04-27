;;; Sierra Script 1.0 - (do not remove this comment)
;
; SCI Template Game
; By Brian Provinciano
; ******************************************************************************
; initrooms.sc
; Contains a room which initializes the rooms and calls the first room.
(script# INITROOMS_SCRIPT)
(include sci.sh)
(include game.sh)
(use main)
(use controls)
(use game)
(use obj)
(use menubar)
(use cycle)

(public
	InitRooms 0
)




;	
;	 Modify this function to set up inventory items or flags as necessary.
;	
;	 :param number roomNumber: The room that the game is starting in when being debugged.
;	
;	 Example::
;	
;	 	(150 ; The room number
;	 		; The ego must have the thing if he's in this room.
;	 		(gEgo get: INV_THETHING)
;	 	)
;	
;	 See also: :doc:`/debugging`
(procedure (DebugRoomInit roomNumber)
	(switch roomNumber
	)
)

; (100
; (gEgo get:"INV_THETHING)
; )
(instance InitRooms of Rm
	(properties
		script 0
		number 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style 6
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 35536
	)
	
	(method (init)
		(ProgramControl)
		(= gProgramControl FALSE)
		(SL disable:)
		(TheMenuBar hide:)
		(super init:)
		(gEgo
			view: 0
			posn: -1 -1
			setStep: 1 1
			setMotion: MoveTo 3000 100
			setCycle: Walk
			init:
		)
		(gGame setSpeed: 0)
	)
	
	(method (doit)
		(super doit:)
		(gGame setSpeed: 6)
		(= gTimeSeconds 0)
		(= gTimeMinutes 0)
		(= gTimeHours 0)
		(= gEgoView 0)
		(TheMenuBar draw:)
		(SL enable:)
		(if (!= -1 gDebugStartRoom)
			(DebugRoomInit gDebugStartRoom)
			; The debug start room
			(gRoom newRoom: gDebugStartRoom)
		else
			; The normal start room
			(gRoom newRoom: 1)
		)
	)
)
